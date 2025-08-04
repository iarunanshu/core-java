2.Multithreading and Concurrency in Java:
Ways to Create a Thread
There are two common ways to define the task that a thread will execute.
1. Implementing the Runnable Interface (Preferred Method)
How it works: You create a class that implements the Runnable interface. The code you want the thread to execute goes inside the run() method. To start it, you create an instance of your Runnable class and pass it to the constructor of a new Thread().

        Why it's preferred: This approach is more flexible. Since your class is only implementing an interface, it is still free to extend another parent class. This promotes better object-oriented design by separating the task (Runnable) from the execution mechanism (Thread).

    2. Extending the Thread Class
        How it works: You create a class that directly extends the Thread class and you override the run() method.

        Limitation: This is less flexible because Java does not support multiple inheritance of classes. Once your class extends Thread, it cannot extend any other class.

## The Thread Lifecycle
    A thread moves through several states from its creation to its termination.

        NEW: The thread object has been created (new Thread()) but the start() method has not yet been called. It is not yet alive.

        RUNNABLE: After start() is called, the thread is in the RUNNABLE state. It is now eligible to be run by the system's scheduler. This state encompasses both being "ready to run" and "actually running" on the CPU.

        BLOCKED: The thread is temporarily inactive because it is waiting to acquire a monitor lock to enter a synchronized block or method that is currently held by another thread.

        WAITING: The thread is temporarily inactive because it has called object.wait(). It will remain in this state until another thread calls object.notify() or object.notifyAll() on the same object.

        TIMED_WAITING: The thread is temporarily inactive for a specified amount of time, for example, by calling Thread.sleep(milliseconds) or object.wait(milliseconds). It automatically returns to the RUNNABLE state when the timer expires.

        TERMINATED: The thread has completed the execution of its run() method and is now dead. It cannot be restarted.

## Synchronization and Inter-Thread Communication
        Threads often need to coordinate their actions, especially when working with shared resources.

        Monitor Lock (synchronized)
        Every object in Java has an intrinsic lock associated with it, called a monitor lock.

        The synchronized keyword ensures that only one thread can execute a specific block of code (or method) on a given object instance at a time.

        When a thread enters a synchronized block, it acquires the object's monitor lock. Other threads attempting to enter a synchronized block on the same object will be put into the BLOCKED state until the lock is released.

        Inter-Thread Communication (wait(), notify(), notifyAll())
        These methods, which belong to the Object class, are the primary mechanism for threads to communicate. They must be called from within a synchronized block.

        wait(): Causes the current thread to release the monitor lock and enter the WAITING state.

        notify(): Wakes up a single random thread that is waiting on the same object's monitor lock.

        notifyAll(): Wakes up all threads that are waiting on the same object's monitor lock. The awakened threads will then compete to acquire the lock again.

        This mechanism is famously used to solve the Producer-Consumer Problem, where a "producer" thread adds items to a shared queue and must wait() if the queue is full, while a "consumer" thread removes items and must wait() if the queue is empty.

3.Multithreading and Concurrency in Java
Producer-Consumer Problem: The Solution
This section provides a solution to the classic Producer-Consumer problem, where producer and consumer threads share a fixed-size queue.
The Goal: The producer must wait if the queue is full, and the consumer must wait if it is empty.

        The Implementation:

            Create a shared resource object that contains a queue and a max buffer size.

            Both the produce() and consume() methods must be synchronized to ensure thread safety.

            Producer Logic: Before adding an item, it checks while (queue.isFull()). If true, it calls wait(), causing the producer to pause and release the lock. After adding an item, it calls notify() to wake up a potentially waiting consumer.

            Consumer Logic: Before removing an item, it checks while (queue.isEmpty()). If true, it calls wait(). After removing an item, it calls notify() to wake up a potentially waiting producer.

        ## Why stop(), resume(), and suspend() are Deprecated
            These methods are considered unsafe and should not be used because they can easily lead to deadlocks and corrupt data.

            stop(): This method terminates a thread abruptly. Its primary danger is that it does not release the monitor locks held by the terminated thread. This can leave other threads that are waiting for those locks permanently blocked.

            suspend(): This method pauses a thread, but unlike wait(), it does not release its monitor locks. If a suspended thread is holding a lock that other threads need, the application will deadlock.

            resume(): This is the counterpart to suspend() and is deprecated for the same reason. The modern, safe alternative is to use wait() and notify()/notifyAll() for inter-thread communication.

        ## Other Important Threading Concepts
            Thread Joining (thread.join())
            What it is: A method that forces the current thread to pause and wait until the thread it is called on has finished its execution.

            When to use: It's essential for coordinating tasks. If the main thread needs the result from a worker thread before it can proceed, it will call workerThread.join() to wait for it to complete.

        Thread Priority (thread.setPriority())
            What it is: You can set a thread's priority from 1 (lowest) to 10 (highest).

⚠️ Important Caveat: Setting a priority is only a hint to the operating system's thread scheduler. There is no guarantee that a higher-priority thread will be executed before a lower-priority one. Do not rely on thread priority to control the execution order of your program.

        Daemon Threads
            What they are: Background threads that provide services to "user" threads (the normal threads you create).

            Key Behavior: The Java Virtual Machine (JVM) will exit as soon as the last user thread completes. It does not wait for daemon threads to finish; they are abruptly terminated.

        How to create: Call thread.setDaemon(true) before you call thread.start().

        Common Examples: The Garbage Collector, auto-save features in an editor, and background logging services are often implemented as daemon threads.

4.Locks and Condition | Java Multithreading
## The Problem with synchronized
The synchronized keyword works by placing a monitor lock on a specific object instance. This is effective if all threads are competing for a resource through the same object. However, if different threads create different instances of an object, each thread will lock its own instance, and mutual exclusion for a critical section of code will fail. Advanced locks solve this by decoupling the lock from any specific object.

        ## Advanced Lock Types
        1. ReentrantLock
        What it is: A direct, more flexible replacement for the synchronized block.

        How it works: You create a ReentrantLock object and share it among threads. Threads must explicitly call lock() to acquire it and unlock() (typically in a finally block) to release it.

        Key Feature: It allows you to enforce mutual exclusion across different object instances by having them all share and use the same lock object.

        2. ReadWriteLock
        What it is: A lock that maintains a pair of associated locks—one for reading and one for writing. This is ideal for data structures where reads are much more frequent than writes.

        How it works:

        Read Lock (Shared Lock): Multiple threads can hold a read lock simultaneously, allowing for high concurrency during read operations.

        Write Lock (Exclusive Lock): Only one thread can hold the write lock at a time. To acquire a write lock, no other thread can be reading or writing.

        3. StampedLock
        What it is: An even more advanced lock that provides read, write, and optimistic read modes.

        Key Feature (Optimistic Reading): This mode allows a thread to perform a read without the full overhead of acquiring a read lock.

        The thread gets a version "stamp" using tryOptimisticRead().

        It reads the data.

        It then calls validate(stamp) to check if any write has occurred since the stamp was issued.

        If valid, the read is successful. If not, the thread knows the data is stale and must retry, perhaps by acquiring a full read lock.

        4. Semaphore
        What it is: A lock that controls access to a resource by maintaining a set of "permits."

        How it works: You initialize a Semaphore with a specific number of permits (e.g., new Semaphore(5)). A thread calls acquire() to take a permit and release() to return it. If no permits are available, the acquire() call blocks.

        Key Feature: It allows a fixed number of threads to access a resource or critical section concurrently, not just one. It's perfect for managing resource pools like database connections.

        ## Inter-thread Communication with Locks: The Condition Interface
        The traditional wait() and notify() methods are tied to an object's monitor lock and do not work with the Lock framework. The replacement is the Condition interface.

        How it works: You create a Condition object from a Lock instance (e.g., lock.newCondition()).

        Equivalent Methods:

        condition.await() is the equivalent of wait().

        condition.signal() is the equivalent of notify().

        condition.signalAll() is the equivalent of notifyAll().

        This allows for the same powerful producer-consumer communication patterns but with the added flexibility of the advanced Lock implementations.

5.Lock-Free Concurrency | Compare-and-Swap:
## Lock-Free Concurrency: The Compare-and-Swap (CAS) Operation
While locks (synchronized, ReentrantLock) are powerful, they can introduce overhead. For certain simple operations, a faster, lock-free approach is possible using a hardware-level instruction called Compare-and-Swap (CAS).

        How CAS Works
        CAS is an atomic operation that takes three arguments: a memory location (V), an expected old value (A), and a new value (B). It works like this:

        It checks if the current value at memory location V is equal to the expected value A.

        If they are equal, it updates the value at V to the new value B and returns true.

        If they are not equal, it does nothing and returns false. This indicates that another thread has modified the value in the meantime.

        This entire process happens as a single, uninterruptible hardware operation, making it incredibly efficient. It's conceptually similar to optimistic locking in databases.

        ## Atomic Variables (AtomicInteger, AtomicBoolean, etc.)
        The Problem They Solve
        Simple operations like counter++ are not atomic. This single line of code is actually three separate steps: (1) read the value of counter, (2) add one to it, and (3) write the new value back. In a multithreaded environment, this can lead to race conditions and incorrect final values.

        The Solution
        Java's atomic classes, like AtomicInteger, solve this problem by using the underlying CAS operation.

        When you call a method like incrementAndGet(), it runs a loop internally.

        In each iteration, it reads the current value and then uses CAS to try and update it to the new, incremented value.

        If the CAS operation fails (meaning another thread changed the value), the loop simply retries with the newly updated value.

        This ensures that the increment operation is atomic and thread-safe without using traditional locks.

        When to use: Atomic variables are perfect for simple, high-contention scenarios like managing shared counters or flags.

        ## Atomic vs. Volatile: A Key Distinction
        These two keywords are often confused, but they solve different problems.

        Feature	volatile	Atomic Classes
Primary Goal	Guarantees Visibility.	Guarantees Atomicity for compound operations.
How It Works	Forces reads and writes to go directly to main memory, bypassing CPU caches.	Uses the hardware-level CAS operation.
Use Case	Ensuring one thread sees the most up-to-date value written by another thread.	Safely performing read-modify-write operations (like i++) in a multithreaded context.

In short, volatile makes sure you see the latest value, while AtomicInteger makes sure you can safely update that value.

        ## Concurrent Collections
        Java provides a rich set of thread-safe collections in the java.util.concurrent package (e.g., ConcurrentHashMap, PriorityBlockingQueue). These collections use the same advanced concurrency mechanisms internally. Some, like PriorityBlockingQueue, use explicit locks (ReentrantLock), while others, like ConcurrentLinkedQueue, use lock-free CAS operations for maximum performance.
