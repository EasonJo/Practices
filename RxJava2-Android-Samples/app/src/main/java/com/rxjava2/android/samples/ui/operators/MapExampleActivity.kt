package com.rxjava2.android.samples.ui.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.rxjava2.android.samples.R
import com.rxjava2.android.samples.model.ApiUser
import com.rxjava2.android.samples.model.User
import com.rxjava2.android.samples.utils.AppConstant
import com.rxjava2.android.samples.utils.Utils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Map是将一种类型的数据转化成另外一种数据类型,然后再通过 Observable发送出去
 * FlatMap将一个发送事件的上游Observable变换为多个发送事件的Observables，
 * 然后将它们发射的事件合并后放进一个单独的Observable里.
 * Created by amitshekhar on 27/08/16.
 */
class MapExampleActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var textView: TextView

    private val observable: Observable<List<ApiUser>>
        get() = Observable.create { e ->
            if (!e.isDisposed) {
                e.onNext(Utils.getApiUserList())
                e.onComplete()
            }
        }

    private val observer: Observer<List<User>>
        get() = object : Observer<List<User>> {

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(userList: List<User>) {
                textView.append(" onNext")
                textView.append(AppConstant.LINE_SEPARATOR)
                for (user in userList) {
                    textView.append(" firstname : " + user.firstname)
                    textView.append(AppConstant.LINE_SEPARATOR)
                }
                Log.d(TAG, " onNext : " + userList.size)
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(AppConstant.LINE_SEPARATOR)
                Log.d(TAG, " onComplete")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        btn = findViewById(R.id.btn) as Button
        textView = findViewById(R.id.textView) as TextView

        btn.setOnClickListener { doSomeWork() }
    }

    /*
    * Here we are getting ApiUser Object from api server
    * then we are converting it into User Object because
    * may be our database support User Not ApiUser Object
    * Here we are using Map Operator to do that
    */
    private fun doSomeWork() {
        observable
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .map { apiUsers -> Utils.convertApiUserListToUserList(apiUsers) }
                .doOnNext { users -> Log.i(TAG, "accept() called with: users = [$users]") }
                .subscribe(observer)


        //flatMap
        getObservale("1", "2", "3")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { s ->
                    Log.i(TAG, "apply() called with: s = [" + s + "],Thread is " + Thread.currentThread().name)
                    Observable.just(true, false, false, true)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { aBoolean ->
                    textView.append(aBoolean.toString() + "")
                    textView.append(AppConstant.LINE_SEPARATOR)
                }

        //concatMap
        getObservale("1", "2", "3")
                .concatMap { Observable.just(true, true, true, true, true) }
                .subscribe { aBoolean ->
                    textView.append(aBoolean.toString() + "")
                    textView.append(AppConstant.LINE_SEPARATOR)
                }


    }

    private fun getObservale(vararg permission: String): Observable<String> {
        return Observable.fromArray(*permission)
    }

    companion object {

        private val TAG = MapExampleActivity::class.java.getSimpleName()
    }


}