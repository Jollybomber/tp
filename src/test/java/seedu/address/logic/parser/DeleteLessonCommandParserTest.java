package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteLessonCommand;
import seedu.address.model.person.Subject;

public class DeleteLessonCommandParserTest {
    private DeleteLessonCommandParser parser = new DeleteLessonCommandParser();
    @Test
    public void parse_allFieldsPresent_success() {
        DeleteLessonCommand expectedCommand = new DeleteLessonCommand(Index.fromZeroBased(0),
                Index.fromZeroBased(1), new Subject("Math"));
        assertParseSuccess(parser, "1 2 \\sMath", expectedCommand);
    }

    @Test
    public void parse_missingPrefix_failure() {
        assertParseFailure(parser, "1 2", "Invalid command format! \n" + DeleteLessonCommand.MESSAGE_USAGE);
    }

    @Test
    public void parse_invalidSubject_failure() {
        assertParseFailure(parser, "1 2 \\s", Subject.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_invalidIndex_failure() {
        assertParseFailure(parser, "a 2 \\sMath", "Invalid command format! \n" + DeleteLessonCommand.MESSAGE_USAGE);
    }
}