package kryvyy.course.pllug.om.courseproject.ui.main.todo;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.data.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.TodosRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class TodosPresenter implements InterfaceView.Todos, InterfaceRepository.Todos {
    private TodosRepository mTodosRepository;
    private InterfacePresenter.Todos mInterfaceTodosPresenter;
    private TodosView mTodosView;

    public TodosPresenter(InterfacePresenter.Todos interfaceTodosPresenter) {
        mInterfaceTodosPresenter = interfaceTodosPresenter;
        mTodosRepository = new TodosRepository(this);
        mTodosView = new TodosView(this);
    }

    public void getTodo(Integer postId) {
        mTodosRepository.getTodo(postId);
    }

    public void getTodosByUser(Integer idUser) {
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
