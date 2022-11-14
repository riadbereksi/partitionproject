package partition.dto;

import java.util.List;

public class PartitionDTO {
    private List<Integer> partitionList;
    private int subListSize;

    public PartitionDTO() {
    }

    public PartitionDTO(List<Integer> partitionList, int subListSize) {
        this.partitionList = partitionList;
        this.subListSize = subListSize;
    }

    public List<Integer> getPartitionList() {
        return partitionList;
    }

    public void setPartitionList(List<Integer> partitionList) {
        this.partitionList = partitionList;
    }

    public int getSubListSize() {
        return subListSize;
    }

    public void setSubListSize(int subListSize) {
        this.subListSize = subListSize;
    }
}
