package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

public class FindByNumberCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same number, same case: matched
        assertFindByNumberCommandBehavior("91119111", Arrays.asList(td.amy));

        //different number, no match
        assertFindByNumberCommandBehavior("13576", Collections.emptyList());

    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindByNumberCommandBehavior(String number, List<ReadOnlyPerson> expectedPersonList) {
        FindByNumberCommand command = createFindByNumberCommand(number);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.feedbackToUser);
    }

    private FindByNumberCommand createFindByNumberCommand(String number) {
        FindByNumberCommand command = new FindByNumberCommand(number);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
