
## **Workers & Machines Analogy for Threads**

* **CPU Core → Machine** ⚙️

  A physical CPU core is like a machine that can perform work.

* **Thread → Worker** 👷

  A thread is like a worker assigned to operate a machine.

* **Program → Factory** 🏭

  Your program is like a factory where tasks need to be completed.

---

## **How it plays out**

1. **One worker per machine**

   * A single machine can only be operated by **one worker at a time**.
   * If a worker is busy reading instructions (waiting for I/O), the machine is idle until they can resume.

2. **More workers than machines** (Overloaded)

   * Extra workers can’t all use a machine simultaneously.
   * They must wait in line. The factory manager (operation system) keeps **switching workers in and out** of machines (*context switching*), which wastes time.

3. **Fewer workers than machines** (Underutilized)

   * Some machines sit idle because there’s no worker assigned to them.

4. **Efficient staffing**

   * You aim to balance the number of workers (threads) with the number of machines (CPU cores) and the nature of the tasks (CPU-bound vs. I/O-bound).

---

## **Context Switching**

### Thread Context Switch: The diagram shows the process of switching between two threads (Thread A and Thread B).

* Switch Out: The current thread (Thread A) is being paused.

* Switch In: Another thread (Thread B) is being resumed.

### Steps in Context Switching:

* Save Registers: The state of Thread A's registers is saved to memory.

* Load Registers: The saved state of Thread B's registers is restored to the CPU.

<img width="621" height="512" alt="image" src="https://github.com/user-attachments/assets/e71e6ea3-1e52-4a9a-9e30-5f8df5edec10" />

---

## **Concurrency vs parallelism**



<img width="1290" height="561" alt="Concurrency vs parallelism" src="https://github.com/user-attachments/assets/4fb9c108-bef2-4e8b-b728-d79725cb321a" />

### 1. Not Concurrent, Not Parallel

* Tasks run one after another (sequentially) on a single CPU core.

### 2. Concurrent, Not Parallel

* Tasks appear to run simultaneously (via time-slicing/context switching) but are executed on a single core.
* only a single thread is executed at a time, but due to fast context switching between threads, It gives an illusion that threads are running parallelly


### 3. Not Concurrent, Parallel

* Tasks run truly simultaneously on multiple cores, but each task is independent and completes without interleaving.

### 4. Concurrent and Parallel

* Tasks both interleave (concurrency) and run simultaneously on multiple cores (parallelism), maximizing efficiency.
