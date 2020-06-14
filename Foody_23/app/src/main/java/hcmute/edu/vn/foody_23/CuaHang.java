package hcmute.edu.vn.foody_23;

import android.widget.ImageView;

public class CuaHang {

    private String  name,score,address,distance,type,imageCount,commentCount;
    private int image;

    public CuaHang(String name, String score, String address, String distance, String type, String imageCount, String commentCount, int image) {
        this.name = name;
        this.score = score;
        this.address = address;
        this.distance = distance;
        this.type = type;
        this.imageCount = imageCount;
        this.commentCount = commentCount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }

    public String getType() {
        return type;
    }

    public String getImageCount() {
        return imageCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
