package cpu;
import processes.Process;

public class ExecutionThread extends Thread{
	Process process;
	
	public ExecutionThread(Process process) {
		this.process=process;
		start();
	}
	@Override
	public void run() {
		CPU.execute(process);
	}
}
