package partition;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import partition.dto.PartitionDTO;
import partition.service.business.contract.IListPartitionnerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class ListPartionnerServiceTest {

    @Autowired
    IListPartitionnerService listPartitionnerService;

    @Test
    public void partitionListTest(){
        //Given
        PartitionDTO partitionDTO = new PartitionDTO(Arrays.asList(1,2,3,4,5,6),5);
        List<List<Integer>> expectedList = Arrays.asList(Arrays.asList(1,2,3,4,5),Arrays.asList(6));

        //When
        List<List<Integer>> resultList = listPartitionnerService.partitionList(partitionDTO);

        //Then
        Assert.assertTrue(expectedList.containsAll(resultList));

    }
}
