package com.arunanshu.multithreading;

public class ThreadPoolNotes {
    /*
6.Thread Pools in Java | ThreadPoolExecutor Framework
    A ThreadPool reuses a collection of worker threads to execute tasks, which improves performance by avoiding the cost of creating new threads for every task. The ThreadPoolExecutor class allows for fine-grained control over this pool. The key to sizing it correctly is to balance the nature of your tasks (CPU vs. I/O bound) with your system's hardware resources (CPU cores and memory).

    ## Key Concepts & Advantages
        What is a Thread Pool?
        A collection of pre-created, reusable worker threads.
        When a new task is submitted, an available thread from the pool is assigned to it.
        Once the task is complete, the thread returns to the pool, ready to pick up a new task.

        Key Advantages
        Improved Performance: Saves significant time by avoiding the overhead of thread creation for each new task.
        Reduced Complexity: The framework manages the complex lifecycle of threads (creation, running, waiting, termination) for you.
        Resource Control: Prevents resource exhaustion by limiting the total number of concurrent threads, which reduces CPU context-switching and improves overall throughput.

## Deep Dive: The ThreadPoolExecutor
        The ThreadPoolExecutor is a highly customizable class for creating thread pools. Its behavior is determined by several key parameters.

        Execution Flow
        When a new task is submitted, the ThreadPoolExecutor follows these steps in order:
        Check Core Threads: If the number of running threads is less than the corePoolSize, it creates a new thread to handle the task.
        Attempt to Queue: If all core threads are busy, it tries to add the task to the workQueue.
        Create Max Threads: If the queue is full, it tries to create a new thread, as long as the total number of threads is less than the maximumPoolSize.
        Reject Task: If the queue is full and the maximum pool size has been reached, the task is rejected according to the RejectedExecutionHandler policy.

        Configuration Parameters
        corePoolSize: The number of threads to keep in the pool, even if they are idle. These are the first threads to be created.
        maximumPoolSize: The maximum number of threads that can ever be created in the pool.
        keepAliveTime & TimeUnit: The duration an idle thread (above corePoolSize) will wait before it is terminated.
        workQueue: A BlockingQueue (e.g., ArrayBlockingQueue) used to hold tasks when all core threads are busy. Its size is a critical configuration point.
        threadFactory: A factory for creating new threads, allowing you to customize thread names, priority, or daemon status.
        rejectedExecutionHandler: A policy that defines what to do when a task is rejected (e.g., throw an exception, discard the task, run it on the calling thread).

## The Interview Question: How to Determine the Pool Size?
        Question: "Why did you choose a core pool size of 2, and not 10 or 15? What is the logic?"

        The answer is not a single number but a process of analysis based on several factors.
        1. Influencing Factors
        CPU Cores: The number of available CPU cores is the primary constraint on true parallelism.
        Task Nature:
        CPU-Bound Tasks: These tasks perform intensive calculations. The ideal pool size is often close to the number of CPU cores to minimize context switching.
        I/O-Bound Tasks: These tasks spend most of their time waiting for external operations (e.g., database calls, network requests). A larger pool size is beneficial here, as the CPU can work on other threads while one is waiting for I/O.
        JVM Memory: Each thread requires memory (for its stack), and the tasks themselves consume heap memory. You cannot create more threads than your available memory can support.
        2. A Formula for Estimation
        A common starting point for calculating the optimal number of threads is Little's Law, simplified here:

        3. The Final Answer
        "The chosen pool size is an estimate based on analysis. For a CPU-bound application, I'd start with a pool size close to the number of CPU cores . For an I/O-bound application, I'd use the formula to estimate a larger pool size. However, this is just a starting point. The final numbers must be derived by considering JVM memory constraints (heap and stack size) and validated through load testing and performance profiling to find the optimal configuration that maximizes throughput for our specific use case."

7.CompletableFuture | Future & Callable in Java
        What's the Point of Future, Callable, and CompletableFuture?
        They provide ways to manage the results and status of asynchronous tasks running on separate threads. While a simple Runnable fires off a task and forgets about it, these tools allow the main thread to track the task's completion, get a result back, handle exceptions, and even chain multiple asynchronous operations together into a powerful pipeline.

## Future and Callable
        Future
        A Future is essentially a placeholder for the result of an asynchronous operation. When you submit a task to a ThreadPoolExecutor, it immediately returns a Future object. The main thread can continue its work and use this Future object later to check on the task.

        Key Methods:
        get(): This is a blocking call. It waits for the async task to complete and then returns its result.
        get(timeout, unit): A version of get() that waits for a specified amount of time before throwing a TimeoutException.
        isDone(): Checks if the task has completed (either normally, with an error, or by cancellation).
        cancel(): Attempts to cancel the running task.

        Callable
        A Callable is just like a Runnable, but with one key difference: it can return a value. This is the most direct way to get a result from an asynchronous task. When you submit a Callable, the Future it returns will be typed to the Callable's return value (e.g., Future<String>).

        In short: You submit a Callable to get a Future, and you call get() on the Future to retrieve the value the Callable returned.

## CompletableFuture (Java 8+)
        CompletableFuture is a major upgrade to the Future interface. It provides a non-blocking, fluent API for chaining and combining multiple asynchronous tasks. It can be seen as the modern way to handle async programming in Java.

        You can think of it as building a pipeline for your data where each stage can be processed asynchronously.

        Key Capabilities & Methods
        Initiating an Async Task:

        supplyAsync(Supplier<T>): Starts a task on a separate thread that will eventually supply a result of type T. This is the most common way to start a CompletableFuture chain.

        Chaining Operations (Processing a result):

        thenApply(): Takes the result from the previous stage, applies a function to it, and passes the new result to the next stage. This runs on the same thread as the previous task.

        thenApplyAsync(): Does the same thing as thenApply but runs the function on a different thread from the thread pool, allowing for more parallelism.

        thenAccept(): Takes the result from the previous stage and performs a final action (like printing to the console). It doesn't return a value, so it's often used at the end of a chain.

        thenCompose(): Used to chain two dependent async operations. When a function itself returns a CompletableFuture, thenCompose is used to flatten the result and avoid nested futures like CompletableFuture<CompletableFuture<String>>.

        Combining Independent Operations:

        thenCombine(): Used when you have two independent CompletableFutures running and you want to do something with their results once both are complete.

        Example of a Chain:
        // This pseudo-code shows the concept of chaining
        CompletableFuture.supplyAsync(() -> fetchUser(userId)) // Stage 1: Get user data (async)
                        .thenApply(user -> enrichUserData(user)) // Stage 2: Add more data (async)
                        .thenAccept(enrichedUser -> displayUser(enrichedUser)); // Stage 3: Do something with the final result

8.ForkJoinPool, WorkStealingPool, FixedThreadPool, CachedThreadPool & SingleThread
        Executors Utility Class
        The Executors class is a utility that provides factory methods for creating common types of pre-configured ThreadPoolExecutor instances. It simplifies the process so you don't always have to manually specify corePoolSize, maximumPoolSize, queues, etc.

        Key Factory Methods:

        newFixedThreadPool(int nThreads)
        What it is: Creates a thread pool with a fixed number of threads. The core and maximum pool sizes are the same.
        Queue: It uses an unbounded queue, so if all threads are busy, new tasks will wait in the queue.
        Best for: Situations where you know the exact number of concurrent tasks needed and want to limit concurrency.

        newCachedThreadPool()
        What it is: Creates a thread pool that dynamically creates new threads as needed.
        Key Behavior: It has a core pool size of 0 and an effectively unlimited maximum size. It doesn't use a real queue; instead, it hands off tasks directly to a thread. Idle threads are terminated after 60 seconds.
        Best for: Executing many short-lived, bursty tasks.

        newSingleThreadExecutor()
        What it is: Creates a thread pool with only a single worker thread.
        Key Behavior: It guarantees that tasks will execute sequentially in the order they were submitted.
        Best for: When you need tasks to be processed one after another, not concurrently.

## The ForkJoinPool and Work-Stealing
        The ForkJoinPool is a special kind of executor designed for tasks that can be broken down into smaller pieces recursively. It uses an algorithm called work-stealing to maximize CPU usage and throughput.

        How It Works: Fork, Join, and Steal
        Fork: A large task is submitted to the pool. The framework recursively breaks this task down into smaller subtasks. This is the "fork" step.
        Local Queues: Unlike a standard thread pool with one central queue, each thread in a ForkJoinPool has its own double-ended queue (deque) where it places its subtasks.

        Work-Stealing:
        A thread always works on tasks from the front of its own deque.
        If a thread finishes all its tasks and becomes idle, it looks at other busy threads and steals a task from the back of their deque.
        This "stealing" ensures that all threads stay busy, dramatically improving performance for divisible tasks.
        Join: Once all the subtasks are completed, their results are recursively combined to produce the final result of the original large task. This is the "join" step.

        How to Create Divisible Tasks
        To make your tasks compatible with the ForkJoinPool, you extend one of two classes:
        RecursiveTask<V>: Use this when your task needs to return a result.
        RecursiveAction: Use this when your task does not return a result (i.e., its compute() method is void).
        Inside the compute() method you implement, you decide whether the task is small enough to solve directly or if it needs to be "forked" into smaller subtasks.

9.Java ScheduledThreadPoolExecutor || Shutdown Vs AwaitTermination
        The differences between the three main methods for shutting down an ExecutorService: shutdown(), awaitTermination(), and shutdownNow().
        How to use the ScheduledThreadPoolExecutor to run tasks after a specific delay or at repeated intervals.

## Shutting Down an Executor Service
        This section addresses a common interview question about the differences between the shutdown methods.

        shutdown()
        What it does: Initiates an orderly shutdown.
        Behavior:
        The executor stops accepting new tasks. Any attempt to submit a new task will result in a RejectedExecutionException.
        Tasks that have already been submitted (both those currently running and those waiting in the queue) are allowed to run to completion.
        Blocking: This is a non-blocking call. It returns immediately, and the main thread continues its execution without waiting for the tasks to finish.

        awaitTermination(long timeout, TimeUnit unit)
        What it does: This is not a shutdown method. It is a blocking call used to wait for an executor to terminate after a shutdown has been initiated.
        Behavior:
        It must be called after shutdown() or shutdownNow().
        It blocks the calling thread until either all tasks have completed, the timeout period expires, or the current thread is interrupted.
        Return Value: Returns true if the executor terminated successfully within the timeout period, and false if the timeout elapsed before termination.

        shutdownNow()
        What it does: Initiates an abrupt shutdown. It tries to stop the executor as quickly as possible.

        Behavior:
        The executor stops accepting new tasks.
        It makes a "best-effort" attempt to interrupt all actively running tasks.
        It drains the task queue and returns a list of tasks that were waiting to be executed, so they are never run.

## ScheduledThreadPoolExecutor
        This is a specialized thread pool that can schedule commands to run after a given delay or to execute periodically.

        Key Scheduling Methods
        schedule(task, delay, timeUnit)
        Executes a Runnable or Callable task one time after the specified delay.
        scheduleAtFixedRate(task, initialDelay, period, timeUnit)
        Executes a task repeatedly after an initialDelay.
        The next task is scheduled to start period duration after the start time of the previous task.

        Important: If a task's execution takes longer than the period, the next task will start immediately after the current one finishes. The system will try to "catch up."

        scheduleWithFixedDelay(task, initialDelay, delay, timeUnit)
        Executes a task repeatedly after an initialDelay.
        The next task is scheduled to start delay duration after the completion time of the previous task.

        This guarantees a fixed amount of idle time between task executions, regardless of how long each task takes.

10.Java VirtualThreads vs Normal Threads || ThreadLocal in Java
        ThreadLocal: How to create variables that are scoped to an individual thread, ensuring data safety without explicit synchronization.

        Virtual Threads vs. Platform Threads: The key differences between Java's traditional "normal" threads and the modern, lightweight virtual threads introduced in Project Loom.

        ## ThreadLocal
        A ThreadLocal variable provides a way to store data that is confined to a specific thread. Each thread that accesses a ThreadLocal variable gets its own independent copy of that variable.

        How It Works
        You create a single, shared ThreadLocal object.
        When a thread calls threadLocal.set(value), the value is stored in a private map-like structure inside that specific thread object.
        When the same thread calls threadLocal.get(), it retrieves its own value. Other threads cannot see or modify this value.
        This is useful for storing per-thread context like user IDs, transaction information, or request details without passing them as parameters through every method call.

        ⚠️ The Importance of remove()
        In a ThreadPoolExecutor, threads are reused. If you set a ThreadLocal value for a thread and don't clean it up, that value will still be present when the same thread is reused to run a different task later.
        This can lead to memory leaks and incorrect behavior.
        Best Practice: Always call threadLocal.remove() in a finally block to ensure the thread's local storage is cleared after the task is complete.

        ## Virtual Threads vs. Platform Threads (Normal Threads)
        This section addresses a common interview question comparing Java's two thread models. The main goal of virtual threads is to achieve higher throughput for applications that have many concurrent, I/O-bound tasks.

        Platform Threads (Normal Threads)
        What they are: These are the traditional threads that Java has always used.
        Mapping: There is a 1-to-1 mapping between a Java platform thread and an underlying operating system (OS) thread.

        Disadvantages:
        Heavyweight: OS threads are a limited and expensive resource to create and manage.
        Blocking is Wasteful: When a platform thread blocks on an I/O operation (e.g., waiting for a database query), its underlying OS thread is also blocked and cannot do any other work, wasting a valuable system resource.

        Virtual Threads
        What they are: Lightweight threads managed entirely by the JVM, not the OS. You can create millions of them without running out of resources.
        Mapping: Many virtual threads run on a small pool of platform threads (known as carrier threads). This is a many-to-one mapping.
        The Key Advantage:
        When a virtual thread blocks on I/O, the JVM automatically unmounts it from its carrier platform thread.
        The now-free carrier thread can immediately mount and run a different, non-blocked virtual thread.
        This prevents OS threads from being idly blocked, allowing a small number of platform threads to handle a massive number of concurrent virtual threads efficiently.
        How to create them: You can use factory methods like Executors.newVirtualThreadPerTaskExecutor() or Thread.startVirtualThread(runnable)
     */
}
