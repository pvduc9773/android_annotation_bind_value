package com.pvduc9773

import android.os.Bundle

/**
 * Created by pvduc9773 on 5/23/20.
 */

/**
 * Annotation @GetValue
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class GetValue(val key: String)

object StdBindValue {
    /**
     * BindData
     */
    fun bindValue(target: Any, bundle: Bundle) {
        val declaredFields = target::class.java.declaredFields
        for (field in declaredFields) {
            for (annotation in field.annotations) {
                when (annotation) {
                    is GetValue -> {
                        field.isAccessible = true
                        field.set(target, bundle.get(annotation.key))
                    }
                }
            }
        }
    }
}