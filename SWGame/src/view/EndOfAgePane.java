package view;

import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.ModelService;
import model.Player;

public class EndOfAgePane extends BorderPane {
    public Label endOfAgeLabel = new Label( "END OF AGE");
    public Label conflictResLabel = new Label( "Military Conflict Resolutions");
    /*public Separator horizontal1 = new Separator(Orientation.HORIZONTAL);
    public Separator horizontal1 = new Separator(Orientation.HORIZONTAL);
    public Separator horizontal1 = new Separator(Orientation.HORIZONTAL);*/
    public TableView table = new TableView();
    public TableColumn<String, Player> column1 = new TableColumn<>("Players");
    //public TableColumn<String, Player> column2 = new TableColumn<>("Points Earned");
    public TableColumn<String, Player> column3 = new TableColumn<>("Total Points");
    public VBox tableBox = new VBox(table);
    ModelService modelService = ModelService.getInstance();

    public EndOfAgePane(){
        table.getColumns().add(column1);
        //table.getColumns().add(column2);
        table.getColumns().add(column3);

        column1.setCellValueFactory( new PropertyValueFactory<>("name"));
        column3.setCellValueFactory( new PropertyValueFactory<>("conflictPoints"));
        
    }
}
