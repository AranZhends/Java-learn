package org.example.dao;

import org.example.model.Image;
import org.junit.Test;


public class ImageDAOTest {

    @Test
    public void queryCount() {
    }

    @Test
    public void insert() {
        Image image = new Image();
        image.setContentType("image/jpeg");
        image.setPath("F:\\TMP\\135d596c14a421a3a38deed2b3f90bdf");
        image.setMd5("135d596c14a421a3a38deed2b3f90bdf");
        image.setUploadTime("2021-05-15 14:56:18");
        image.setSize((long) 30889);
        image.setImageName("QQ图片20201006125137.jpg");
        ImageDAO imageDAO = new ImageDAO();
        int flag = imageDAO.insert(image);
        System.out.println(image);
        System.out.println(flag);
    }

    @Test
    public void queryAll() {
    }

    @Test
    public void queryOne() {
    }

    @Test
    public void delete() {
        int imageId = 13;
        ImageDAO imageDAO = new ImageDAO();
        int flag = imageDAO.delete(imageId);

        System.out.println(flag);
    }
}