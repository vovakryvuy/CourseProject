package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 16.06.2018.
 */

public class TodosRepository {
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private InterfaceRepository.Todos mInterfaceTodosRepository;
    private Todo mTodo;
    private List<Todo> mTodos;

    public TodosRepository (InterfaceRepository.Todos interfaceRepository) {
        this.mInterfaceTodosRepository = interfaceRepository;
    }

    public void getTodo(Integer todoId){
        mInterfaceResponse.getTodo(todoId).enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                mTodo = response.body();
                mInterfaceTodosRepository.getTodo(mTodo);
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }
        });
    }

    public void getTodosByUser(Integer idUser){
        mTodos = new ArrayList<>();
        mInterfaceResponse.getTodosByUser(idUser).enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                mTodos = response.body();
                mInterfaceTodosRepository.getTodos(mTodos);
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }
}
