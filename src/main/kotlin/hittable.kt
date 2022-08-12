

abstract class Hittable {

     //Inner class
    class HitRecord(var _orig: Point3, var _normal: Vec3 , var _t: Double) {
        //Properties
        var p = _orig
        var normal  = _normal
        var t = _t

    }

        abstract fun hit(r: Ray, t_min: Double, t_max: Double,rec: HitRecord): Boolean

    }

