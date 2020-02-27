package de.kersten.domain.route.publisher;

import de.kersten.domain.route.Route;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.springframework.stereotype.Component;

/**  
* rxjava based publisher
* 
* @author Andre Kersten
*/

@Component
public class RouteUpdatePublisher {

    private final Flowable<Route> publisher;
    private ObservableEmitter<Route> observableEmitter;

    public RouteUpdatePublisher() {
        // create reactive streams
        Observable<Route> stockPriceUpdateObservable = Observable.create(emitter -> {
            observableEmitter=emitter;
        });

        ConnectableObservable<Route> connectableObservable = stockPriceUpdateObservable.share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    public void emit(Route route) {
        observableEmitter.onNext(route);
    }

    public Flowable<Route> getPublisher() {
        return publisher;
    }

}
