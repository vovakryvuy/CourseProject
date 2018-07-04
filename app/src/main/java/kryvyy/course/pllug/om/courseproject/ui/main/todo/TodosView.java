package kryvyy.course.pllug.om.courseproject.ui.main.todo;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class TodosView {
    private InterfaceView.Todos mInterfaceTodosView;
    private TodoAdapter mTodoAdapter;

    public TodosView(InterfaceView.Todos interfaceTodosView) {
        this.mInterfaceTodosView = interfaceTodosView;
    }

    public void displayListPost(List<Todo> todos){
        mTodoAdapter = new TodoAdapter(todos,mInterfaceTodosView);
        mInterfaceTodosView.setAdapterTodos(mTodoAdapter);
    }
}
