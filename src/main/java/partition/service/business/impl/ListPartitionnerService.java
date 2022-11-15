package partition.service.business.impl;

import org.springframework.stereotype.Service;
import partition.dto.PartitionDTO;
import partition.service.business.contract.IListPartitionnerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListPartitionnerService implements IListPartitionnerService {

    @Override
    public List<List<Integer>> partitionList(PartitionDTO partitionDTO) {
        List<List<Integer>> listTemp = new ArrayList<>();
        List<Integer> initialList = partitionDTO.getPartitionList();
        int subListSize = partitionDTO.getSubListSize();

        int i = 0;
        List<Integer> subList = new ArrayList<>();
        while (i < initialList.size()) {
            subList.add(initialList.get(i));
            i++;
            if (subList.size() == subListSize || i == initialList.size()) {
                listTemp.add(subList);
                subList = new ArrayList<>();
            }
        }
        return listTemp;

    }
}
