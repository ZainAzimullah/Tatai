package tatai.expressionModel.custom;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This is a adapter/wrapper class which converts
 * a CustomLevelSettings object into an equivalent object
 * with StringProperties which can be used to build tables.
 * This is needed because properties are not serializable.
 */
public class CustomLevelProperties {
    private StringProperty _dateCreated, _name;
    private CustomLevelSettings _settings;

    public CustomLevelProperties(CustomLevelSettings settings) {
        _settings = settings;

        _name = new SimpleStringProperty(settings.getName());
        _dateCreated = new SimpleStringProperty(settings.getDateCreated());
    }

    public CustomLevelSettings getSettings() {
        return _settings;
    }

    public String getDateCreated() {
        return _dateCreated.get();
    }

    public StringProperty dateCreatedProperty() {
        return _dateCreated;
    }

    public String getName() {
        return _name.get();
    }

    public StringProperty nameProperty() {
        return _name;
    }
}
