package Java;

import java.util.ArrayList;

/**
 * Created by Conor on 28-Oct-16.
 */
public class Dispacher {

    private Context context;
    private final ArrayList<I_Interceptor> listofInterceptors;

    public Dispacher (){
        listofInterceptors  = new ArrayList<I_Interceptor>();
    }

    public void register(I_Interceptor interceptor){
        listofInterceptors.add(interceptor);
        System.out.println("Registered Interceptor");
    }

    public void remove(I_Interceptor interceptor){
        if(listofInterceptors.contains(interceptor))
            listofInterceptors.remove(interceptor);
        else
            System.out.print("interceptor Object not in List");
    }

    private void iteratelist(){
        for (I_Interceptor listofInterceptor : listofInterceptors) {
            listofInterceptor.InterceptorMethod1(context);
        }
    }

    public void callBack(Context context) {
        this.context = context;
        iteratelist();
    }
}
