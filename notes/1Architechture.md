Step 1: Java Source Code → Bytecode by Java Compiler (javac)
When you install the JDK, the javac compiler is included in the bin directory
Step 2: Bytecode → Machine Code (at runtime) by Java Virtual Machine (JVM)
The JVM executes the bytecode. Internally,
the JVM uses:
Interpreter (to interpret bytecode line by line)
Just-In-Time (JIT) Compiler (to convert bytecode into native machine code for better performance during execution)

        JVM's internal workings
        1. Classloader Subsystem
        The Classloader Subsystem is responsible for loading, linking, and initializing .class files. It's the first component to come into action when you execute a Java program.

        Loading: This phase involves finding and loading the .class file for a given class name.

                 Bootstrap Classloader: Loads core Java API classes (e.g., java.lang.*, java.util.*) from the rt.jar (or jmods in newer Java versions) located in the <JAVA_HOME>/jre/lib directory. It's implemented in native code.

                 Extension Classloader: Loads classes from the ext directory (<JAVA_HOME>/jre/lib/ext) or any directory specified by the java.ext.dirs system property.

                 Application Classloader (System Classloader): Loads classes from the classpath defined by the -classpath or -cp command-line options, or the CLASSPATH environment variable. This is the classloader that loads your application's classes.

                 Delegation Hierarchy: Classloaders follow a delegation model. When a class needs to be loaded, the request is first delegated upwards to its parent. If the parent can load the class, it does. Otherwise, the child classloader attempts to load it. This prevents duplicate loading and ensures security.

        Linking: This phase connects the loaded classes.

                 Verification: Checks the bytecode for structural correctness and security violations (e.g., ensuring that code doesn't try to forge pointers or violate access restrictions). If verification fails, a VerifyError is thrown.

                 Preparation: Allocates memory for static variables and initializes them to their default values (e.g., 0 for numeric types, null for objects, false for booleans). It does not execute static initializers at this stage.

                 Resolution: Replaces symbolic references in the constant pool with direct references. For example, if your code calls System.out.println(), the symbolic reference to System.out and the println method will be resolved to their actual memory addresses. This can happen eagerly or lazily.

        Initialization: This is the final phase of class loading.

                It executes the static initializers and static blocks present in the class in the order they appear in the source code.
                It initializes static variables to their actual values specified in the code.

        A class is initialized only once.

        2. JVM Memory Areas (Runtime Data Areas)
            Method Area (Shared):
                Stores class-level data, including:
                The bytecode of methods.
                Runtime constant pool (including symbolic references to methods and fields, and direct references that are resolved during linking).
                Field and method data (names, types, modifiers).
                Static variables.
                Information about classes and interfaces.
                It is shared among all threads.

                In Java 8 and later, the Method Area is part of Metaspace, which is native memory (not part of the JVM heap). This helps avoid OutOfMemoryError related to class metadata and allows for dynamic resizing. In Java 7 and earlier, it was part of the Permanent Generation (PermGen) of the heap.

            Heap Area (Shared):
                This is where all objects and their corresponding instance variables and arrays are stored.
                It's the largest part of JVM memory.
                It's shared among all threads.
                This is the area where Garbage Collection (GC) primarily operates to reclaim memory from unused objects.

                The Heap is logically divided into:
                Young Generation: Where new objects are initially allocated.
                Eden Space: Most new objects are created here.
                Survivor Spaces (S0 and S1): Objects that survive initial garbage collections in Eden are moved between these two spaces.
                Old Generation (Tenured Generation): Objects that survive multiple garbage collection cycles in the Young Generation are promoted here. Long-lived objects reside here.

            Stack Area (Per Thread):
                Each thread in the JVM has its own private Stack.
                A Stack Frame is created for every method invocation.
                Each Stack Frame contains:
                    Local Variable Array: Stores local variables and method parameters. Primitive types are stored directly, while object references are stored here (the actual objects reside in the Heap).

                    Operand Stack: Used for intermediate computations. Bytecode instructions push and pop values onto this stack.
                    Frame Data (Constant Pool Reference): Points to the runtime constant pool of the method's class.

                    When a method is called, a new frame is pushed onto the stack. When the method completes, its frame is popped.
                    StackOverflowError occurs if the stack space is exhausted (e.g., due to infinite recursion).

            PC Registers (Program Counter Registers) (Per Thread):
                Each JVM thread has its own PC Register.
                It stores the address of the currently executing JVM instruction.
                If the method being executed is a native method, the PC Register's value is undefined.

            Native Method Stacks (Per Thread):
                Similar to Java Stacks, but used for native methods (methods written in languages like C/C++ and called via JNI).
                If a native method is called, a native stack frame is created.
                Can also throw StackOverflowError.

        3. Execution Engine
                The Execution Engine is responsible for executing the bytecode loaded by the Classloader.

                Interpreter: Reads and executes bytecode instruction by instruction. It's fast at starting up but generally slower for long-running code because it re-interprets the same code every time it's encountered.

                Just-In-Time (JIT) Compiler:
                 To overcome the performance limitations of the interpreter, the JIT compiler comes into play.
                 It identifies "hot spots" (frequently executed code segments or methods) and compiles them into highly optimized native machine code.

                The JIT compiler uses various optimization techniques like:
                Inlining: Replacing method calls with the actual method body.
                Loop unrolling: Replicating loop body to reduce loop overhead.
                Dead code elimination: Removing unreachable code.

                Escape analysis: Determining if an object's scope can be confined to a method or thread, potentially allowing it to be allocated on the stack (stack allocation) or eliminating it entirely.
                The JIT compilation process happens at runtime, dynamically adapting to the application's execution profile.

        Garbage Collector (GC):
            The GC is an essential part of the Execution Engine, responsible for automatically reclaiming memory occupied by objects that are no longer referenced by the program.
            It frees developers from manual memory management, reducing memory leaks and simplifying development.

            Key GC algorithms include:
            Mark-and-Sweep: Marks reachable objects, then sweeps (deletes) unmarked objects.
            Copying: Divides memory into two halves; copies live objects from one half to the other, then reclaims the entire source half. Used in Young Generation.
            Mark-and-Compact: Similar to mark-and-sweep, but after marking, it compacts the live objects to reduce fragmentation. Used in Old Generation.
            Modern GCs (like G1, ZGC, Shenandoah) are highly sophisticated, aiming for lower pause times and higher throughput.
            Garbage Collection Roots: Objects are considered reachable if they are directly or indirectly referenced from GC roots. GC roots include:

            Local variables and parameters in active stack frames.

            Static variables.

            JNI local references.
            Threads themselves.
            Native Method Interface (JNI - Java Native Interface):
            Allows Java code to interact with native applications and libraries written in other languages (like C/C++).
            It enables Java programs to call native methods and native methods to call back into Java code.

            Native Method Library:
            A collection of native libraries (e.g., C/C++ libraries) required by the Execution Engine. These libraries are typically platform-dependent.