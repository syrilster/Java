Java has a commercial version having some different features than the opensource one. Example commercial java has a tool to measure performance known as java flight recorder.

**JVM tuning:**
* Boolean flags syntax:
    * Enable the flag using: -XX: +FlagName
    * Disable the flag using: -XX: -FlagName
* Flags that require parameter:
    XX: FlagName=something

## Premature Optimization:
Donald Knuth - We should forget about small efficiencies, say about 97% of the time, premature optimization is the root of all evil. Always prefer to write clean, straightforward code that is simple
to read and understand.

**Choose Macro Benchmarking vs Micro Benchmarking**
* Check the sample fibonacci implementation for micro benchmarking where the compiler has applied some optimizations.
* Profile Feedback - The compiler uses profile feedback based on which methods are frequently called, the stack depth when they are called,
the actual type of their arguments and so on.
* The above also depends on the environment in which the code actually runs.
* The best way to measure the performance of an application is the application itself, in conjunction with any external resources it uses.
* If the application normally checks the credentials of a user by making LDAP calls, it should be tested in that mode. Stubbing out the LDAP calls is necessary so that the application is tested in its full configuration.


