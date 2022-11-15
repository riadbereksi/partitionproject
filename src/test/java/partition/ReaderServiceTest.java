package partition;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import partition.dto.PartitionDTO;
import partition.exception.InputException;
import partition.service.util.contract.IReaderService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class ReaderServiceTest {
    @Autowired
    private IReaderService readerService;


    @Test
    public void readTest(){
        //Given
        String listSize = "2\n";
        String listValues = "1\n2\n";
        String subListSize = "1\n";
        byte[] inputBytes = (listSize+listValues+subListSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        List<Integer> expectedList = Arrays.asList(1,2);

        //When
        PartitionDTO result = readerService.read();

        //Then
        Assert.assertEquals(2, result.getPartitionList().size());
        Assert.assertEquals(1, result.getSubListSize());
        Assert.assertTrue(expectedList.containsAll(result.getPartitionList()));
    }

    @Test(expected = InputException.class)
    public void readTest_listSizeNotNumericSize(){
        //Given
        String listSize = "z\n";
        byte[] inputBytes = (listSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
        readerService.read();
    }

    @Test(expected = InputException.class)
    public void readTest_listSizeNegative(){
        //Given
        String listSize = "-1\n";
        byte[] inputBytes = (listSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
         readerService.read();
    }

    @Test(expected = InputException.class)
    public void readTest_valueNotNumeric(){
        //Given
        String listSize = "2\n";
        String listValues = "1\nz\n";
        byte[] inputBytes = (listSize+listValues).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
        readerService.read();
    }

    @Test(expected = InputException.class)
    public void readTest_subListSizeNotNumericSize(){
        //Given
        String listSize = "2\n";
        String listValues = "1\n2\n";
        String subListSize = "z\n";
        byte[] inputBytes = (listSize+listValues+subListSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
        readerService.read();
    }

    @Test(expected = InputException.class)
    public void readTest_subListSizeNegative(){
        //Given
        String listSize = "2\n";
        String listValues = "1\n2\n";
        String subListSize = "-21\n";
        byte[] inputBytes = (listSize+listValues+subListSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
        readerService.read();
    }

    @Test(expected = InputException.class)
    public void readTest_subListSizeBigger(){
        //Given
        String listSize = "2\n";
        String listValues = "1\n2\n";
        String subListSize = "5\n";
        byte[] inputBytes = (listSize+listValues+subListSize).getBytes();
        InputStream inputs = new ByteArrayInputStream(inputBytes);
        System.setIn(inputs);

        //When
        readerService.read();
    }

}
