package pl.promity.patterns.dynamicfactory.interfaces;

import com.google.common.base.Preconditions;
import pl.promity.patterns.common.Command;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Dynamic factory example for registering mini factories.
 */
public class CommandDynamicFactory {

    private final ConcurrentHashMap<String, CommandMaker> commandMakersRegistry;

    public CommandDynamicFactory() {
        commandMakersRegistry = new ConcurrentHashMap<>();
    }

    public void registerCommandMaker(String key, CommandMaker maker){
        Preconditions.checkNotNull(key, "trying to register command maker with null key");
        Preconditions.checkNotNull(maker, "trying to register null command maker");
        commandMakersRegistry.putIfAbsent(key, maker);
    }

    public Command createCommand(String key){
        Preconditions.checkNotNull(key, "trying to create command with null key");
        Optional<CommandMaker> commandMaker = Optional.ofNullable( commandMakersRegistry.get(key) );
        if( commandMaker.isPresent() ){
            return commandMaker.get().createCommand();
        }
        else{
            throw new IllegalArgumentException("Can't find any command maker associated with given key "+key);
        }
    }

}
