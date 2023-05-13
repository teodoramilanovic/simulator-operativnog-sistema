package processes;

import java.util.Queue;

import memory.RAM;
import cpu.ExecutionThread;

public class ProcessScheduler {
	
	public static synchronized void schedule() {
		Queue<Process>readyQueue=RAM.getReadyQueue();
		if(!readyQueue.isEmpty() && RAM.getRunningProcess() == null) {
			Process process=readyQueue.remove();
			RAM.setRunningProcess(process);
			process.setState("RUNNING");
			new ExecutionThread(process);
		}
	}
}
