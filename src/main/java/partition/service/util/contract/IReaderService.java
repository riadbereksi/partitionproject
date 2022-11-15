package partition.service.util.contract;

import partition.dto.PartitionDTO;
import partition.exception.InputException;

public interface IReaderService {
    PartitionDTO read() throws InputException;
}
