import kotlin.math.sqrt


// Alias for readability
typealias Point3  = Vec3 // 3D point
typealias Color = Vec3; // RGB color




class Vec3(var _e0: Double = 0.0, var _e1: Double = 0.0, var _e2: Double = 0.0) {

     //Type

    //Properties
    var e0 = _e0
    var e1 = _e1
    var e2 = _e2
    override fun toString(): String {
        return "vec3(e0=$e0, e1=$e1, e2=$e2)"
    }




    // Custom functions
    fun x () :Double{
        return e0
    }

    fun y () :Double{
        return e1
    }

    fun z () :Double{
        return e2
    }


    fun length_squared(): Double{

        return  e0*e0 + e1*e1 + e2*e2;
    }

    fun length() : Double {
        return sqrt(length_squared())
    }





    // Operator Overloading
    operator fun unaryMinus(): Vec3 {
          return Vec3(-e0,-e1,-e2)
    }

    operator fun plus(vector_2: Vec3): Vec3 {

        return Vec3(_e0=_e0+vector_2._e0,_e1=_e1+vector_2._e1,_e2=_e2+vector_2._e2)
    }

    operator fun minus(vector_2: Vec3): Vec3 {

        return Vec3(_e0=_e0-vector_2._e0,_e1=_e1-vector_2._e1,_e2=_e2-vector_2._e2)
    }

    operator fun times(multiple: Double): Vec3 {
        return Vec3(_e0=multiple*_e0,_e1=multiple*_e1,_e2=multiple*_e2)
    }

    operator fun div(multiple: Double): Vec3 {
        return Vec3(_e0=_e0/multiple,_e1=_e1/multiple,_e2=_e2/multiple)
    }

    operator fun get(index: Int): Double {

        if (index ==0) {
            return _e0
        }
        else if (index ==1) {
            return _e1
        }
        else if (index ==2) {
            return _e2
        }
        else {
            return 0.0    //You should throw some error here
        }

    }


}


// vec3 Utility Functions


/*
inline vec3 operator+(const vec3 &u, const vec3 &v) {
return vec3(u.e[0] + v.e[0], u.e[1] + v.e[1], u.e[2] + v.e[2]);
}
inline vec3 operator-(const vec3 &u, const vec3 &v) {
return vec3(u.e[0] - v.e[0], u.e[1] - v.e[1], u.e[2] - v.e[2]);
}
inline vec3 operator*(const vec3 &u, const vec3 &v) {
return vec3(u.e[0] * v.e[0], u.e[1] * v.e[1], u.e[2] * v.e[2]);
}
inline vec3 operator*(double t, const vec3 &v) {
return vec3(t*v.e[0], t*v.e[1], t*v.e[2]);
}
inline vec3 operator*(const vec3 &v, double t) {
return t * v;
}
inline vec3 operator/(vec3 v, double t) {

 */

fun dot(vector_1: Vec3,vector_2: Vec3) : Double {

    return  vector_1[0] * vector_2[0] +
            vector_1[1] * vector_2[1] +
            vector_1[2] * vector_2[2]
}

fun cross(u: Vec3,v: Vec3): Vec3 {
    return Vec3(u[1] * v[2] - u[2] * v[1], u[2] * v[0] - u[0] * v[2],u[0] * v[1] - u[1] * v[0])
}


fun  unit_vector(v: Vec3): Vec3 {
    return v / v.length();
}
