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
annotation class GetValue(val key: String, val type: TYPE)

/**
 * EnumClassTypeValue
 */
enum class TYPE {
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    STRING,
    SERIALIZABLE,
    PARCELABLE
}

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
                        when (annotation.type) {
                            TYPE.INT -> {
                                field.set(target, bundle.getInt(annotation.key))
                            }
                            TYPE.LONG -> {
                                field.set(target, bundle.getLong(annotation.key))
                            }
                            TYPE.FLOAT -> {
                                field.set(target, bundle.getFloat(annotation.key))
                            }
                            TYPE.DOUBLE -> {
                                field.set(target, bundle.getDouble(annotation.key))
                            }
                            TYPE.STRING -> {
                                field.set(target, bundle.getString(annotation.key))
                            }
                            TYPE.SERIALIZABLE -> {
                                field.set(target, bundle.getSerializable(annotation.key))
                            }
                            TYPE.PARCELABLE -> {
                                field.set(target, bundle.getParcelable(annotation.key))
                            }
                        }
                    }
                }
            }
        }
    }
}