package partition;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import partition.service.util.contract.IReaderService;
import partition.service.util.impl.ReaderService;

@SpringBootApplication
public class PartitionProjectRbApplication implements ApplicationRunner {

	@Autowired
	private IReaderService readerService;

	public static void main(String[] args) {
		SpringApplication.run(PartitionProjectRbApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) {
		configLogger();

		readerService.read();
	}

	private static void configLogger() {
		BasicConfigurator.configure();
	}
}
