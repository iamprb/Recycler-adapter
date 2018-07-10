package me.pranay.drawit.base

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

open class AbstractBaseNormalActivity:AppCompatActivity(){

     var fragmentToChange : Fragment?=null
    var isAddToBackStack:Boolean=false

    fun changeFragment(mFragment: Fragment?,addToBackStack:Boolean){
        this.fragmentToChange=mFragment
        this.isAddToBackStack=addToBackStack

    }

    fun updateFragment(@IdRes containerID:Int){
        if(this.fragmentToChange==null){
            return
        }
        val backStackName=this.fragmentToChange!!.javaClass.name
        val fragmentManager: FragmentManager = supportFragmentManager
        val isPop:Boolean = fragmentManager.popBackStackImmediate(backStackName,0)
        if((!isPop) && (fragmentManager.findFragmentByTag(backStackName)==null)){
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(containerID,this.fragmentToChange,backStackName)
            if(this.isAddToBackStack){
                fragmentTransaction.addToBackStack(backStackName)
            }
            fragmentTransaction.commit()
        }
        this.isAddToBackStack=false
        this.fragmentToChange=null
    }
}