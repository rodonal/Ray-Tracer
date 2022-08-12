class Sphere(var _center: Point3, var _radius: Double) : Hittable() {

    //Properties
    var center = _center
    var radius = _radius


    override fun hit(r: Ray, t_min: Double, t_max: Double, rec: HitRecord): Boolean {
        var oc = r.origin() - center
        var a = r.direction().length_squared()
        var half_b = dot(oc,r.direction())
        var c = oc.length_squared() - radius*radius
        //left here somewhere

        return true
    }
}