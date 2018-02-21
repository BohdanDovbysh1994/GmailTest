package testdata;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

import java.util.ArrayList;

public class ReportAppender extends AppenderSkeleton {
    private ArrayList<LoggingEvent> eventsList = new ArrayList();

    @Override
    protected void append(LoggingEvent event) {
        eventsList.add(event);
        Reporter.log(event.getMessage().toString());
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }
}
