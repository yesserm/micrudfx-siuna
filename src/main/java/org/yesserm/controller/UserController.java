package org.yesserm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.yesserm.entity.Post;
import org.yesserm.entity.User;
import org.yesserm.service.GenericServiceImpl;
import org.yesserm.service.IGenericService;
import org.yesserm.utils.HibernateUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    public Button btnlogin;
    public TextField txtuser;
    public TextField txtpass;
    public Label lbwelcome;
    ObservableList<User> usuarios;
    private User usuarioLogueado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearUsuario();
    }

    private void crearUsuario() {
        usuarios = getUsuarios();
        if (usuarios.isEmpty()) {
            User usuario = new User();
            usuario.setUsername("yesser");
            usuario.setPassword("1234");

            IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil
                    .getSessionFactory());
            usuarioService.save(usuario);
            usuarioLogueado = usuario;
            usuarios.add(usuario);
        }
    }

    private ObservableList<User> getUsuarios() {
        IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class,
                HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(usuarioService.findAll());
    }

    public void loginUser() {
        String user = txtuser.getText();
        String pass = txtpass.getText();
        boolean flag = false;
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(user) && usuario.getPassword().equals(pass)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            lbwelcome.setText("Welcome " + user);
        } else {
            lbwelcome.setText("Invalid user or password");
        }
    }

    public void testPost() {
        Post post = new Post();
        post.setTitle("Post 1");
        post.setContent("Content 1");
        post.setUser(usuarioLogueado);

        IGenericService<Post> postService = new GenericServiceImpl<>(Post.class, HibernateUtil
                .getSessionFactory());
        postService.save(post);
    }
}
