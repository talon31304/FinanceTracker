package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by kboermeester on 9/28/2014.
 */
public interface FileHandler {

    FileReader readTransactionFile(String filename) throws IOException;

    FileWriter writeTransactionFile(String filename) throws IOException;

    void importTransactions(FileReader importfile) throws IOException;

    void exportTransactions(FileWriter exportfile) throws  IOException;
}
