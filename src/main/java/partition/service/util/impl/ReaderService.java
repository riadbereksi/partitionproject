package partition.service.util.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import partition.dto.PartitionDTO;
import partition.exception.InputException;
import partition.service.util.contract.IReaderService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class ReaderService implements IReaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderService.class);

    public PartitionDTO read() {
        List<Integer> partitionList = readScPartitionList();
        return new PartitionDTO(partitionList, readScSubListSize(partitionList.size()));
    }

    private List<Integer> readScPartitionList() {
        LOGGER.info("Début lecture de la liste");
        Scanner sc = new Scanner(System.in);
        int partitionListSize = -1;
        while (partitionListSize <= 0) {
            try {
                System.out.println("Entrez la taille de la liste");
                partitionListSize = sc.nextInt();
                if (partitionListSize <= 0) {
                    LOGGER.error(InputException.NEGATIVE_LIST_SIZE);
                }
            } catch (InputMismatchException e) {
                LOGGER.error(InputException.LIST_SIZE_NOT_NUMERIC);
                sc = new Scanner(System.in);
                partitionListSize = -1;
            }
        }

        List<Integer> partitionList = new ArrayList<>();
        for (int i = 0; i < partitionListSize; i++) {
            boolean isRead = false;
            while (!isRead) {
                try {
                    System.out.println("Element numero " + (i + 1));
                    partitionList.add(sc.nextInt());
                    isRead = true;
                } catch (InputMismatchException e) {
                    LOGGER.error(InputException.VALUE_NOT_NUMERIC);
                    sc = new Scanner(System.in);
                }
            }

        }
        LOGGER.info("Fin lecture de la liste");
        return partitionList;
    }

    private int readScSubListSize(int partitionListSize) {
        LOGGER.info("Début lecture de la taille de la sous-liste");

        Scanner sc = new Scanner(System.in);
        int subListSize = -1;
        while (subListSize <= 0 || partitionListSize < subListSize) {
            try {
                System.out.println("Entrez la taille de la sous liste");
                subListSize = sc.nextInt();
                if (subListSize <= 0) {
                    LOGGER.error(InputException.NEGATIVE_PARTITION_SIZE);
                } else if (partitionListSize < subListSize) {
                    LOGGER.error(InputException.PARTITION_BIGGER_LIST);
                }
            } catch (InputMismatchException e) {
                LOGGER.error(InputException.PARTITION_SIZE_NOT_NUMERIC);
                sc = new Scanner(System.in);
                subListSize = -1;
            }
        }

        LOGGER.info("Fin lecture de la taille de la sous-liste");
        return subListSize;
    }
}
