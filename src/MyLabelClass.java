import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Created by trail on 2017-06-11.
 */
public class MyLabelClass {
    private Text labeltext = null;
    private ImageView imageView = null;
    private Line line = null;

    public void setLabeltextPos(int posX, int posY) {
        labeltext.setX(posX);
        labeltext.setY(posY);
        line.setStartX(posX);
        line.setStartY(posY);
    }

    MyLabelClass(int posX, int posY, String labelString, Rectangle border, AnchorPane planPane) {
        labeltext = new Text();
        labeltext.setX(posX);
        labeltext.setY(posY);
        labeltext.setText(labelString);

        imageView = new ImageView();
        imageView.setX(posX);
        imageView.setY(posY);
        imageView.setFitHeight(10);
        imageView.setFitWidth(10);

        imageView.setImage(FormeManager.getImagecross());


        line = new Line();
        line.setStartX(posX);
        line.setStartY(posY);
        line.setEndX(posX);
        line.setEndY(posY);



        labeltext.setOnMouseDragged(event -> {
            if(!FormeManager.isBugMod()) {

                if(event.isPrimaryButtonDown()) {
                    double x = event.getSceneX() - 210;
                    double y = event.getSceneY() - 29;

                    if(x<0) {
                        x=0;
                    }
                    if(y<0) {
                        y=0;
                    }
                    if(x>border.getWidth()) {
                        x=border.getWidth();
                    }
                    if(y>border.getHeight()) {
                        y=border.getHeight();
                    }

                    labeltext.setX(x);
                    labeltext.setY(y);
                    line.setStartX(x);
                    line.setStartY(y);


                }
            }
        });

        imageView.setOnMouseDragged(event -> {
            if(!FormeManager.isBugMod()) {

                if(event.isPrimaryButtonDown()) {
                    double x = event.getSceneX() - 210;
                    double y = event.getSceneY() - 29;

                    if(x<0) {
                        x=0;
                    }
                    if(y<0) {
                        y=0;
                    }
                    if(x>border.getWidth()) {
                        x=border.getWidth();
                    }
                    if(y>border.getHeight()) {
                        y=border.getHeight();
                    }

                    imageView.setX(x);
                    imageView.setY(y);
                    line.setEndX(x);
                    line.setEndY(y);


                }
            }
        });

        ContextMenu contextMenu = new ContextMenu();


        MenuItem itemDelete = new MenuItem("Delete");
        itemDelete.setOnAction(event -> {
            FormeManager.getArrayListOfMyLabel().remove(this);
            planPane.getChildren().remove(labeltext);
            planPane.getChildren().remove(line);
            planPane.getChildren().remove(imageView);

        });

        contextMenu.getItems().add(itemDelete);
        labeltext.setOnContextMenuRequested(event -> {
            if(!FormeManager.isBugMod()) {
                contextMenu.show(labeltext, Side.TOP, 0, 0);

            }

        });
    }

    public Text getLabeltext() {
        return labeltext;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Line getLine() {
        return line;
    }
}
