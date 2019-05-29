package Threads;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTaskExample {
    private boolean killed;
    public static final String dataSourceName = "jdbc/resource name";

    public void executeTask() {
        killed = false;
        boolean successful = run();
        if (!successful || isKilled()) {
            //getContext().postEvent("Task did not finish successfully");
        } else {
            //logger.debug("finished processing job!");
            //getContext().postEvent("Finished processing job");
        }
    }

    private boolean run() {
        final int THREAD_COUNT = 5;
        final int BATCH_SIZE = 1000;

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        //context.postEvent("Thread Count: " + THREAD_COUNT);
        //context.postEvent("Batch Size: " + BATCH_SIZE);
        boolean successful = true;

        try (Connection conn = getNewConnection()) {
            String sql = "your sql here";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFetchSize(BATCH_SIZE);
            ps.setQueryTimeout(0);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Integer> listToProcess = new ArrayList<>();
            ArrayList<Callable<CallableTaskExample.CallableResponse>> callables = new ArrayList<>();

            while (resultSet.next() && !isKilled()) {
                listToProcess.add(resultSet.getInt("subject_key"));

                if (listToProcess.size() % BATCH_SIZE == 0 || resultSet.isLast()) {
                    callables.add(createCallable(listToProcess));
                    listToProcess = new ArrayList<>();
                }
            }

            //context.postEvent("Number of chunks to process: " + callables.size());
            List<Future<CallableResponse>> responses = pool.invokeAll(callables);

            // reprocess chunks if failed
            if (!isKilled()) {
                for (Future<CallableTaskExample.CallableResponse> response : responses) {
                    if (!response.get().isSuccessful()) {
                        //context.postEvent("Attempting to re-process failed chunk");
                        //call your logic method here
                    }
                }
            }
        } catch (Exception e) {
            successful = false;
            //logger.severe(ExceptionUtils.getFullStackTrace(e));
        } finally {
            // shut down executor service
            pool.shutdown();
        }
        return successful;
    }

    private void expireConsentForNonMinors(List<Integer> subjectKeys) {
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
            /*if (getContext().isStopping()) {
                killed = true;
                return true;
            }*/
        }
        return false;
    }

    private Callable<CallableResponse> createCallable(final List<Integer> subjectKeys) {
        return new Callable<CallableResponse>() {
            @Override
            public CallableResponse call() throws Exception {

                boolean successful = true;

                if (isKilled()) {
                    //logger.info("Stopping thread");
                    return new CallableResponse(null, Boolean.FALSE);
                }

                try {
                    //call your logic method here
                } catch (Exception e) {
                    //logger.severe(ExceptionUtils.getFullStackTrace(e));
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
