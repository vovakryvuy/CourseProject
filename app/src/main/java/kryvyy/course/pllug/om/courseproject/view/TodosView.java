package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.TodoAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;

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
