package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.TodoAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.repositories.TodosRepository;
import kryvyy.course.pllug.om.courseproject.view.InterfaceView;
import kryvyy.course.pllug.om.courseproject.view.TodosView;

/**
 * Created by vovak on 16.06.2018.
 */

public class TodosPresenter implements InterfaceView.Todos,InterfaceRepository.Todos {
    private TodosRepository mTodosRepository;
    private InterfacePresenter.Todos mInterfaceTodosPresenter;
    private TodosView mTodosView;

    public TodosPresenter(InterfacePresenter.Todos interfaceTodosPresenter) {
        mInterfaceTodosPresenter = interfaceTodosPresenter;
        mTodosRepository = new TodosRepository(this);
        mTodosView = new TodosView(this);
    }

    public void getTodo(Integer postId){
        mTodosRepository.getTodo(postId);
    }

    public void getTodosByUser(Integer idUser){
        mTodosRepository.getTodosByUser(idUser);
    }

    @Override
    public void getTodo(Todo todo) {

    }

    @Override
    public void getTodos(List<Todo> todos) {
        mTodosView.displayListPost(todos);
    }


    @Override
    public void setAdapterTodos(TodoAdapter adapterTodos) {
        mInterfaceTodosPresenter.setAdapterTodos(adapterTodos);
    }

    @Override
    public void itemClickListener(Todo todo) {
        mInterfaceTodosPresenter.clickTodos(todo);
    }
}
