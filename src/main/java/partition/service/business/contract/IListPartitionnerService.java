package partition.service.business.contract;

import partition.dto.PartitionDTO;

import java.util.List;

public interface IListPartitionnerService {

     List<List<Integer>> partitionList(PartitionDTO partitionDTO);
}
