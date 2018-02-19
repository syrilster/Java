
public class CallableExample extends SingleTask {

    private int upperAge;
    private boolean killed;
    public static final String dataSourceName = "jdbc/resource name";

    @Override
    public void executeTask() {
		killed = false;
		boolean successful = run(getContext());
		if (!successful || isKilled()) {
			getContext().postEvent("Task did not finish successfully");
		} else{
			logger.debug("finished processing job!");
			getContext().postEvent("Finished processing job");
		}       
    }

    private boolean run(TaskContext context) {
        final int THREAD_COUNT = 5;
        final int BATCH_SIZE = 1000;

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        context.postEvent("Thread Count: " + THREAD_COUNT);
        context.postEvent("Batch Size: " + BATCH_SIZE);
        boolean successful = true;

        try (Connection conn = getNewConnection()) {
            String sql = "your sql here";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFetchSize(BATCH_SIZE);
            ps.setQueryTimeout(Constants.NO_QUERY_TIMEOUT);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Integer> listToProcess = new ArrayList<>();
            ArrayList<Callable<CallableExample.CallableResponse>> callables = new ArrayList<>();

            while (resultSet.next() && !isKilled()) {
                listToProcess.add(resultSet.getInt("subject_key"));

                if (listToProcess.size() % BATCH_SIZE == 0 || resultSet.isLast()) {
                    callables.add(createCallable(listToProcess, getContext()));
                    listToProcess = new ArrayList<>();
                }
            }

            context.postEvent("Number of chunks to process: " + callables.size());
            List<Future<CallableExample.CallableResponse>> responses = pool.invokeAll(callables);

            // reprocess chunks if failed
            if (!isKilled()) {
                for (Future<CallableExample.CallableResponse> response : responses) {
                    if (!response.get().isSuccessful()) {
                        context.postEvent("Attempting to re-process failed chunk");
                        //call your logic method here
                    }
                }
            }
        } catch (Exception e) {
            successful = false;
            logger.severe(ExceptionUtils.getFullStackTrace(e));
        } finally {
            // shut down executor service
            pool.shutdown();
        }
        return successful;
    }

    private void expireConsentForNonMinors(List<Integer> subjectKeys, TaskContext taskContext) {
        // Some logic here
    }

    private Connection getNewConnection() throws SQLException, NamingException {
        Context c = new InitialContext();
        DataSource dataSource = (DataSource) c.lookup(dataSourceName);

        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
        return conn;
    }

    private boolean isKilled() {
        if (killed) {
            return true;
        } else {
            if (getContext().isStopping()) {
                killed = true;
                return true;
            }
        }
        return false;
    }

    private Callable<CallableResponse> createCallable(final List<Integer> subjectKeys, final TaskContext taskContext) {
        return new Callable<CallableResponse>() {
            @Override
            public CallableResponse call() throws Exception {

                boolean successful = true;

                if (isKilled()) {
                    logger.info("Stopping thread");
                    return new CallableResponse(null, Boolean.FALSE);
                }

                try {
                    //call your logic method here
                } catch (Exception e) {
                    logger.severe(ExceptionUtils.getFullStackTrace(e));
                    successful = false;
                }
                if (successful) {
                    return new CallableResponse(null, Boolean.TRUE);
                } else {
                    return new CallableResponse(subjectKeys, Boolean.FALSE);
                }
            }
        };
    }

    class CallableResponse {
        private List<Integer> subjectKeys;
        private Boolean successful;

        CallableResponse(List<Integer> subjectKeys, Boolean successful) {
            this.subjectKeys = subjectKeys;
            this.successful = successful;
        }

        public List<Integer> getSubjectKeys() {
            return subjectKeys;
        }

        public void setSubjectKeys(List<Integer> subjectKeys) {
            this.subjectKeys = subjectKeys;
        }

        Boolean isSuccessful() {
            return successful;
        }

        public void setSuccessful(Boolean successful) {
            this.successful = successful;
        }
    }
}
