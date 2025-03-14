package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label gender;
    @FXML
    private Label height;
    @FXML
    private Label weight;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label address;
    @FXML
    private Label diet;
    @FXML
    private FlowPane priorityTag;
    @FXML
    private Label meetingDate;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        gender.setText(person.getGender().gender);
        height.setText(person.getHeight().toString() + " m");
        weight.setText(person.getWeight().toString() + " kg");
        phone.setText(person.getPhone().value);
        email.setText(person.getEmail().value);
        address.setText(person.getAddress().value);
        diet.setText(person.getDiet().toString());
        Label priorityLabel = new Label(person.getPriority().toString());
        priorityLabel.getStyleClass().addAll("priority-label", "priority-"
                + person.getPriority().toString().toLowerCase());
        priorityTag.getChildren().add(priorityLabel);
        meetingDate.setText(person.getMeetingDate().toString());
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));

    }
}
