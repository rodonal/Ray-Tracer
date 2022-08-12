


class Ray (var _orig: Point3, var _dir: Color) {

   //Properties
    var orig = _orig
    var dir  = _dir




    //Class functions

    fun origin(): Point3 {
        return orig
    }

    fun direction(): Color {
        return dir
    }

    fun at (t : Double): Point3 {
        return orig + dir*t
    }

    /*
    vec3 direction() const { return dir; }
point3 at(double t) const {
return orig + t*dir;
}
     */
}


