/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.razegalactic

import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.AutoTransition
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.keyframe1.*

/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.keyframe1)


    val constraintSet1 = ConstraintSet()
    constraintSet1.clone(constraint_layout2)
    val constraintSet2 = ConstraintSet()
    constraintSet2.clone(this, R.layout.activity_main)

    var changed = false

    switch1.setOnClickListener {
      //apply the transition
      TransitionManager.beginDelayedTransition(constraint_layout2)
      val constraint = if (changed) constraintSet1 else constraintSet2
      constraint.applyTo(constraint_layout2)

      changed = !changed
    }
  }

  /**
   *  To view this animation over and over, minimize the app and then re-launch it
   */
  override fun onStart() {
    super.onStart()

    val constraintSet2 = ConstraintSet()
    constraintSet2.clone(this, R.layout.activity_main)

    //apply the transition
//    TransitionManager.beginDelayedTransition(constraint_layout2)
    val transition = AutoTransition()
    transition.duration = 1000
    TransitionManager.beginDelayedTransition(
        constraint_layout2, transition)

    constraintSet2.applyTo(constraint_layout2)

  }


}
