package partition;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import partition.dto.PartitionDTO;
import partition.exception.InputException;
import partition.service.business.contract.IListPartitionnerService;
import partition.service.util.contract.IReaderService;
import partition.service.util.impl.ReaderService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PartitionProjectRbApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReaderService.class);

	@Autowired
	private IReaderService readerService;
	@Autowired
	private	IListPartitionnerService listPartitionnerService;

	@PostConstruct
	public void run() {
		configLogger();
		try {
			PartitionDTO partitionDTO = readerService.read();
			listPartitionnerService.partitionList(partitionDTO).stream()
					.forEach(System.out::println);

		}catch (InputException inputException){
			LOGGER.error(inputException.getMessage());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(PartitionProjectRbApplication.class, args);
	}



	private static void configLogger() {
		BasicConfigurator.configure();
	}
}
