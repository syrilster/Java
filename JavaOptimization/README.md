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

** Choose Macro Benchmarking vs Micro Benchmarking**
* Check the sample fibonacci implementation for micro benchmarking where the compiler has applied some optimizations.
* Profile Feedback - The compiler uses profile feedback based on which methods are frequently called, the stack depth when they are called,
the actual type of their arguments and so on.
* The above also depends on the environment in which the code actually runs.

