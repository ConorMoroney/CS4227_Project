package Java;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by Conor on 28-Oct-16.
 */
public class Dispacher {


    ArrayList<I_Interceptor> listofInterceptors;

    public Dispacher (){
        listofInterceptors  = new ArrayList<I_Interceptor>();
    }

    public void dispatch(){}

    public void register(I_Interceptor interceptor){
        listofInterceptors.add(interceptor);
    }

    public void remove(I_Interceptor interceptor){
        if(listofInterceptors.contains(interceptor))
            listofInterceptors.remove(interceptor);
        else
            System.out.print("interceptor Object not in List");

    }

    public void iteratelist(){

        for(int i = 0;i < listofInterceptors.size();i++){
            //listofInterceptors.get(i).InterceptorMethod1();
        }

    }

    //public Context getContext(){}
}
