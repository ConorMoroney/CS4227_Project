package User;

/**
 * Created by shane on 28-Oct-16.
 */
public abstract class AbstractUserFactory<T> {
    abstract T createUser(String userType);
}
