package br.com.uniacademia.server.dataprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Slf4j
public class StopWordsMemoryListDataProvider {

    private final ArrayList<String> stopWordsMemoryList;

    public StopWordsMemoryListDataProvider(ArrayList<String> stopWordsMemoryList) {
        this.stopWordsMemoryList = stopWordsMemoryList;
    }

    @PostConstruct
    public List<String> execute() {
        if (stopWordsMemoryList.isEmpty()) {
            readFile();
        }

        return stopWordsMemoryList;
    }

    private void readFile() {
        try {
            var s = new Scanner(new File("./stop-words.txt"));
            while (s.hasNext()) {
                stopWordsMemoryList.add(s.next());
            }
            s.close();
        } catch (FileNotFoundException e) {
            log.info("(TweetService.saveTweet) -> Could not read stop-words file.");
            return;
        }
    }

}
