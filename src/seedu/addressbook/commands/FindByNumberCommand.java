package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose number matches exactly the argument keyword.
 * Keyword matching is case sensitive.
 */
public class FindByNumberCommand extends Command {

    public static final String COMMAND_WORD = "findNum";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose number matches exactly "
            + "the specified number (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: NUMBER\n"
            + "Example: " + COMMAND_WORD + " 98765432";

    private final String number;

    public FindByNumberCommand(String number) {
        this.number = number;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public String getNumber() {
        return number;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithMatchingNumber(number);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param number for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithMatchingNumber(String number) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final String numberTest = person.getPhone().toString();
            if (numberTest.equals(number)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
