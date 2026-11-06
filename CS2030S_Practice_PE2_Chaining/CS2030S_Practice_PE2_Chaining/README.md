# CS2030S Practice PE — Chaining, Maybe, Lazy & InfiniteList

**Difficulty:** Slightly harder than the previous practice  
**Suggested time:** 100 minutes  
**Total:** 25 marks

This practice focuses on method chaining and combining `Lazy`, `Maybe`, `InfiniteList`, immutability, and functional programming.

## Setup

This exercise expects the CS2030S functional programming library to be available on your classpath, including `Lazy`, `Maybe`, `InfiniteList`, `Producer`, `Transformer`, and `Combiner`.

Compile the starter files from the project root, adjusting the classpath to your course setup:

```bash
javac -cp .:path/to/cs2030s.jar src/*.java
```

On Windows, use `;` instead of `:` in the classpath.

## Files

- `TASKS.md` — questions only
- `src/` — starter code with TODOs
- `TESTCASES.md` — runnable JShell-style test cases and expected results
- `SOLUTIONS_JSHELL.md` — sample method implementations and JShell examples

Try the questions before opening the solutions.

## Rules

- Do not use loops, arrays, `if`, ternary operators, mutable temporary collections, Java `Optional`, or Java Streams.
- Use the supplied CS2030S `Lazy`, `Maybe`, and `InfiniteList` APIs.
- Preserve method signatures and fields.
- Treat domain classes as immutable.
- `InfiniteList.append()` is not public; do not call it.
- The calibration list is finite.
