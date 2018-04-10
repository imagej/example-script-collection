#@ ModuleService modules

OUTPUT_NAME = "output"

info = modules.getModuleById("script:Umlaute/Föö Bär/To_Be_Run.groovy")
module = modules.createModule(info)
module.resolveOutput(OUTPUT_NAME)

modules.run(module, true).get()

println module.getOutput(OUTPUT_NAME)
