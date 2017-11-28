package uk.ac.cardiffmet.st20131041.allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepositoryFactoryTest;
import uk.ac.cardiffmet.st20131041.domain.db.EventRepositoryInMemoryTest;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepositoryFactoryTest;
import uk.ac.cardiffmet.st20131041.domain.db.PersonRepositoryInMemoryTest;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileReaderJSONTest;
import uk.ac.cardiffmet.st20131041.domain.model.EventFileWriterJSONTest;
import uk.ac.cardiffmet.st20131041.domain.model.EventTest;
import uk.ac.cardiffmet.st20131041.domain.model.LocationTest;
import uk.ac.cardiffmet.st20131041.domain.model.PersonTest;
import uk.ac.cardiffmet.st20131041.domain.service.EventServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    EventFileReaderJSONTest.class,
    EventFileWriterJSONTest.class,
    EventTest.class,
    LocationTest.class,
    PersonTest.class,
    EventRepositoryInMemoryTest.class,
    PersonRepositoryInMemoryTest.class,
    EventRepositoryFactoryTest.class,
    PersonRepositoryFactoryTest.class,
    EventServiceTest.class
})

public class AllTests {
    // the class remains empty,
    // used only as a holder for the above annotations
}
